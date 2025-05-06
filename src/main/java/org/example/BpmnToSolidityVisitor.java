package org.example;

import BpmnSimpleBaseListener;
import BpmnSimpleParser;

import java.util.ArrayList;
import java.util.List;

public class BpmnToSolidityVisitor extends BpmnSimpleBaseListener<String> {
    private List<String> tasks = new ArrayList<>();

    @Override
    public String visitProcess(BpmnSimpleParser.ProcessContext ctx) {
        String name = ctx.ID().getText();
        ctx.element().forEach(this::visit);

        StringBuilder sb = new StringBuilder();
        sb.append("// SPDX-License-Identifier: MIT\n");
        sb.append("pragma solidity ^0.8.0;\n\n");
        sb.append("contract ").append(name).append(" {\n");

        sb.append("    enum State { Created, ");
        sb.append(String.join(", ", tasks));
        sb.append(", Completed }\n");
        sb.append("    State public state;\n\n");

        sb.append("    constructor() { state = State.Created; }\n\n");

        for (int i = 0; i < tasks.size(); i++) {
            String task = tasks.get(i);
            String requiredState = (i == 0) ? "Created" : tasks.get(i - 1);
            sb.append("    function ").append(task.toLowerCase()).append("() public {\n");
            sb.append("        require(state == State.").append(requiredState).append(", \"Invalid state\");\n");
            sb.append("        state = State.").append(task).append(";\n");
            sb.append("    }\n\n");
        }

        sb.append("    function completeProcess() public {\n");
        sb.append("        require(state == State.").append(tasks.get(tasks.size() - 1)).append(", \"Invalid state\");\n");
        sb.append("        state = State.Completed;\n");
        sb.append("    }\n");

        sb.append("}\n");
        return sb.toString();
    }

    @Override
    public String visitTask(BpmnSimpleParser.TaskContext ctx) {
        tasks.add(ctx.ID().getText());
        return null;
    }
}

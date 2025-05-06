grammar BpmnSimpleTask;

@header {
    package com.example.bpmn;
}

process     :   'process' ID '{' element* '}';
element     :   task;
task        :   'task' ID   ';';

ID          :   [a-zA-Z_][a-zA-Z0-9_]* ;
WS          :   [ \t\r\n]+ -> skip ;

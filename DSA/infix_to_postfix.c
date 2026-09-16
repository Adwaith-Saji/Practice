#include <stdio.h>
#include <ctype.h>

#define MAX 100

char stack[MAX];
int top=-1;

void push(char x){
    stack[++top]=x;
}

char pop(){
    return stack[top--];
}

char peek(){
    return stack[top];
}

int precedence(char x){
    if (x == '^')
        return 3;
    if (x == '*' || x == '/' || x == '%')
        return 2;
    if (x == '+' || x == '-')
        return 1;

    return 0;    
}

void infixToPostfix(char infix[]){
    char postfix[MAX];
    int i=0,j=0;
    char x;

    top=-1;

    while(infix[i]!='\0'){
        x=infix[i];

        if(isalnum(x)){
            postfix[j++]=x;
        }
        else if(x=='('){
            push(x);
        }
        else if (x == ')'){
            while (top != -1 && peek() != '(')
                postfix[j++] = pop();

            pop();
        }
        else{
            while (top != -1 && precedence(peek()) >= precedence(x))
                postfix[j++] = pop();

            push(x);            
        }
        i++;
    }

    while (top != -1)
        postfix[j++] = pop();

    postfix[j] = '\0';

    printf("Postfix: %s\n", postfix);
}

int main(){
    char infix[MAX];

    printf("Enter infix expression: ");
    scanf("%s", infix);

    infixToPostfix(infix);

    return 0;
}    

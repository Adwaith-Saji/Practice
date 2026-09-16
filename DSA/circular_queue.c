#include <stdio.h>

#define MAX 5

int queue[MAX];
int front = -1;
int rear = -1;

int isFull(){
    return (rear + 1) % MAX == front;
}

int isEmpty(){
    return front == -1;
}

void enqueue(int x){
    if (isFull())
        printf("Queue Overflow\n");
    else{
        if (isEmpty())
            front = 0;

        rear = (rear + 1) % MAX;
        queue[rear] = x;
    }
}

void dequeue(){
    if (isEmpty())
        printf("Queue Underflow\n");
    else{
        printf("Deleted: %d\n", queue[front]);

        if (front == rear){
            front = rear = -1;
        }
        else{
            front = (front + 1) % MAX;
        }
    }
}

void display(){
    if (isEmpty())
        printf("Queue is empty\n");
    else{
        int i = front;

        while (1){
            printf("%d ", queue[i]);

            if (i == rear)
                break;

            i = (i + 1) % MAX;
        }

        printf("\n");
    }
}

int main(){
    enqueue(10);
    enqueue(20);
    enqueue(30);
    enqueue(40);
    enqueue(50);

    display();

    dequeue();
    dequeue();

    enqueue(60);
    enqueue(70);

    display();

    return 0;
}
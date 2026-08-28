void search(int value) {
    if (head == NULL)
        return;

    struct Node *temp = head;
    int position = 1;

    do {
        if (temp->data == value) {
            printf("%d found at position %d\n", value, position);
            return;
        }

        temp = temp->next;
        position++;

    } while (temp != head);

    printf("%d not found\n", value);
}

void update(int position, int value) {
    if (head == NULL)
        return;

    struct Node *temp = head;

    for (int i = 1; i < position; i++)
        temp = temp->next;

    temp->data = value;
}

int countNodes() {
    if (head == NULL)
        return 0;

    struct Node *temp = head;
    int count = 0;

    do {
        count++;
        temp = temp->next;
    } while (temp != head);

    return count;
}

void reverse() {
    if (head == NULL || head->next == head)
        return;

    struct Node *prev = NULL;
    struct Node *current = head;
    struct Node *next;

    do {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    } while (current != head);

    head->next = prev;
    head = prev;
}
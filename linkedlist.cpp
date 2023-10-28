#include <iostream>

using namespace std;
    class Node{
        public:
        int data;
        Node*next;
    };
    void insertAtStart(Node* &head,int value){
        Node* temp;
        temp= new Node;
        temp->data=value;
        temp->next=head;
        head = temp;
    }
    void insert(Node* &head,int val){
        Node* n = new Node;
        n->data=val;
        if(head==NULL){
            head=n;
            return;
        }
        Node*temp=head;
        while(temp->next!=NULL){
            temp=temp->next;
            
        }
        temp->next=n;
    }
    void insertAtAny(Node* &head,int value, int position){
        Node* n = new Node;
        n->data=value;
        if(head==NULL){
            head=n;
            return;
        }
        Node* temp = head;
        int t = position - 2;
        for(int i=0;i<t+1;i++){
            temp=temp->next;
            if(i==t){
                n->next=temp->next;
                temp->next=n;
            }
        }
    }
    void display(Node* &head){
        Node* ptr;
        ptr = head;
        while(ptr!=NULL){
            cout<<ptr->data<<"->";
            ptr=ptr->next;
        }
        cout<<"NULL"<<endl;
    }
int main()
{
    Node* head = NULL;
    int n;
    cin>>n;
    for(int i=0;i<n;i++){
        int a;
        cin>>a;
        insert(head,a);
    }
    display(head);
    return 0;
}




//NY solution 

using namespace std;

#include <iostream>
#include <vector>

class TreeNode {
 public:
  int val = 0;
  TreeNode *left;
  TreeNode *right;

  TreeNode(int x) {
    val = x;
    left = right = nullptr;
  }
};

class CountAllPathSum {
 public:
  static int countPaths(TreeNode *root, int S) {
    // TODO: Write your code here
    vector<int> prevPaths;
    prevPaths.push_back(0);
    
    return paths(root, S, prevPaths);
  }

  static int paths(TreeNode *root, int s, vector<int> prevPaths){
    if(root == nullptr) return 0;

    int count = 0;
    for(int i = 0; i < prevPaths.size(); i++){
      prevPaths[i] += root->val;
      if(prevPaths[i] == s) count++;
    }
    prevPaths.push_back(root->val);

    return count + paths(root->left, s, prevPaths) + paths(root->right, s, prevPaths);
  }
};

int main(int argc, char *argv[]) {
  TreeNode *root = new TreeNode(12);
  root->left = new TreeNode(7);
  root->right = new TreeNode(1);
  root->left->left = new TreeNode(4);
  root->right->left = new TreeNode(10);
  root->right->right = new TreeNode(5);
  cout << "Tree has path: " << CountAllPathSum::countPaths(root, 11) << endl;
}

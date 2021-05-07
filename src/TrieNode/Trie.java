package TrieNode;

public class Trie {

    // [ 변수 ]
    // 루트 노드
    private TrieNode rootNode;

    // [ 생성자 ]
    Trie() {
        rootNode = new TrieNode();
    }

    // 자식 노드 추가
    void insert(String word) {
        TrieNode thisNode = this.rootNode;

        for (int i = 0; i < word.length(); i++) {
            // 해당 계층 문자의 자식노드가 존재하지 않을 때에만 자식 노드를 생성
            thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        thisNode.setIsLastChar(true);
    }

    /**
     * 특정 단어가 Trie에 존재하는지를 확인하기 위해서는 두가지를 만족시켜야 한다.
     * 1. 루트노드부터 순서대로 알파벳이 일치하는 자식노드들이 존재 할것
     * 2. 해당 단어의 마지막 글자에 해당하는 노드의 isLastChar가 true일 것
     */
    // 특정 단어가 들어있는지 확인
    boolean contains(String word){
        TrieNode thisNode = this.rootNode;

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            TrieNode node = thisNode.getChildNodes().get(character);

            if (node == null)
                return false;

            thisNode = node;
        }

        return thisNode.isLastChar();
    }

    /**
     * contains 메서드처럼 주어진 단어를 찾아 하위 노드로 단어 길이만큼 내려갑니다.
     * 주의할 점은 노드들이 부모노드의 정보를 가지고 있지 않기 때문에, 하위 노드로 내려가며 삭제 대상 단어를 탐색하고
     * 다시 올라오며 삭제하는 과정이 콜백(callback) 형식으로 구현되어야 한다는 점입니다.
     * 탐색 방향 : 부모 노드 -> 자식 노드
     * 삭제 방향 : 자식 노드 -> 부모 노드
     *
     * 삭제 할때 유의할 점
     * 1. 자식 노드를 가지고 있지 않아야 한다.
     * 2. 삭제를 시작하는 첫 노드는 isLastChar == true 여야 한다.
     * 3. 삭제를 진행하던 중에는 isLastChar == false 여야 한다.
     */
    void delete(String word) {
        delete(this.rootNode, word, 0); // 최초로 delete 던지는 부분
    }

    private void delete(TrieNode thisNode, String word, int index) {

        char character = word.charAt(index);

        // 아예 없는 단어인 경우 에러 출력
        if (!thisNode.getChildNodes().containsKey(character)) {
            throw new Error("There is no [" + word + "] in this Trie");
        }

        TrieNode childNode = thisNode.getChildNodes().get(character);
        index++;

        if (index == word.length()) {
            // 삭제 조건 2번 항목
            // PO와 같이 노드는 존재하지만 insert한 단어가 아닌 경우 에러 출력
            if (!childNode.isLastChar()) throw new Error("There is no [" + word + "] in this Trie");

            childNode.setIsLastChar(false);
            // 삭제 조건 1번 항목
            // 삭제 대상 언어의 제일 끝으로써 자식 노드가 없으면(이 단어를 포함하는 더 긴 단어가 없으면) 삭제 시작
            if (!childNode.getChildNodes().isEmpty()) {
                thisNode.getChildNodes().remove(character);
            }
        } else {
            delete(childNode, word, index); // 콜백함수 부분
            // 삭제조건 1,3번 항목
            // 삭제 중, 자식 노드가 없고 현재 노드로 끝나는 다른 단어가 없는 경우 이 노드 삭제
            if (!childNode.isLastChar() && childNode.getChildNodes().isEmpty()) {
                thisNode.getChildNodes().remove(character);
            }
        }
    }


}

package TrieNode;

import java.util.HashMap;
import java.util.Map;

/**
 *  https://the-dev.tistory.com/3?category=1059400 사이트 참고
 *  자식노드는 Trie 차원에서 생성해서 넣을 것이기 때문에 Getter만 생성
 *  마지막 글자 여부는 추후 노드 삭제하는 과정에서 변경이 필요하기 때문에 Getter와 Setter를 둘다 생성해줍니다.
 */
public class TrieNode {

    // [ 변수 ]
    // 자식 노드 맵
    private Map<Character, TrieNode> childNodes = new HashMap<>();
    // 마지막 글자인지 여부
    private boolean isLastChar;

    // [GETTER / SETTER 메서드]
    // 자식 노드 맵 Getter
    public Map<Character, TrieNode> getChildNodes() {
        return this.childNodes;
    }
    // 마지막 글자인지 여부 Getter
    public boolean isLastChar() {
        return this.isLastChar;
    }

    public void setIsLastChar(boolean islastChar) {
        this.isLastChar = islastChar;
    }
}

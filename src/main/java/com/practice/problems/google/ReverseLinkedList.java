package com.practice.problems.google;

import com.practice.problems.grokking.educative.linkedlist.ListNode;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class ReverseLinkedList {

    final BiConsumer<ListNode, ListNode> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract ListNode reverse(ListNode node);

    public void execute() {
        ListNode<Integer> node;
        ListNode<Integer> actual;
        ListNode<Integer> expected;

        node = getListNode1();
        expected = getListNode1Reversed();
        actual = reverse(node);
        log.debug(LOG_STR, getClass().getSimpleName(), node, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }

    private ListNode getListNode1() {
        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        ListNode<Integer> node4 = new ListNode<>(4);
        ListNode<Integer> node5 = new ListNode<>(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node1;
    }

    private ListNode getListNode1Reversed() {
        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        ListNode<Integer> node4 = new ListNode<>(4);
        ListNode<Integer> node5 = new ListNode<>(5);

        node5.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node1;

        return node5;
    }
}

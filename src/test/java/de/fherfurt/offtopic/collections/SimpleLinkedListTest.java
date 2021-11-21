package de.fherfurt.offtopic.collections;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SimpleLinkedListTest {

  @Test
  void shouldAddNewValueToEmptyListAndReturnSize1() {
    // given
    SimpleLinkedList list = new SimpleLinkedList();
    int value = 1;

    // when
    int result = list.add(value);

    // then
    Assertions.assertThat(result).isOne();
  }

  @Test
  void shouldAddNewValueToNonEmptyListAndReturnIncreasedSize() {
    // given
    SimpleLinkedList list = new SimpleLinkedList();
    int value1 = 1;
    list.add(value1);

    int value2 = 2;

    // when
    int result = list.add(value2);

    // then
    Assertions.assertThat(result).isEqualTo(2);
  }

  @Test
  void shouldReturnEmptyStringForEmptyListOnToString() {
    // given
    SimpleLinkedList list = new SimpleLinkedList();

    // when
    String result = list.toString();

    // then
    Assertions.assertThat(result).isBlank();
  }

  @Test
  void shouldReturnStringWithValuesForNonEmptyListOnToString() {
    // given
    SimpleLinkedList list = new SimpleLinkedList();
    list.add(1);
    list.add(3);
    list.add(2);

    // when
    String result = list.toString();

    // then
    Assertions.assertThat(result).isEqualTo("1;3;2;");
  }

  @Test
  void shouldAdd20ValuesToEmptyListAndReturnIncreasedSize() {
    // given
    final Random random = new Random();

    int givenElementCount = 20;
    SimpleLinkedList list = new SimpleLinkedList();

    StringBuilder expected = new StringBuilder();
    for (int index = 0; index < givenElementCount; ++index) {
      int value = random.nextInt();
      list.add(value);

      expected
        .append(value)
        .append(';');
    }

    // when
    String result = list.toString();

    // then
    Assertions.assertThat(list.size()).isEqualTo(givenElementCount);
    Assertions.assertThat(result).isEqualTo(expected.toString());
  }
}

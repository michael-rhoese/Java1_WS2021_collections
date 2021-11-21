package de.fherfurt.offtopic.collections;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class DoubleLinkedListTest {

  @Test
  void shouldAddNewValueToEmptyListAndReturnSize1() {
    // given
    DoubleLinkedList list = new DoubleLinkedList();
    int value = 1;

    // when
    int result = list.add(value);

    // then
    Assertions.assertThat(result).isOne();
  }

  @Test
  void shouldAddNewValueToNonEmptyListAndReturnIncreasedSize() {
    // given
    DoubleLinkedList list = new DoubleLinkedList();
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
    DoubleLinkedList list = new DoubleLinkedList();

    // when
    String result = list.toString();

    // then
    Assertions.assertThat(result).isBlank();
  }

  @Test
  void shouldReturnStringWithValuesForNonEmptyListOnToString() {
    // given
    DoubleLinkedList list = new DoubleLinkedList();
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
    DoubleLinkedList list = new DoubleLinkedList();

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

  @Test
  void shouldAddNewValueAtPositionToEmptyListAndReturnSize1() {
    // given
    DoubleLinkedList list = new DoubleLinkedList();
    int value = 1;

    // when
    int result = list.add(value, 1);

    // then
    Assertions.assertThat(result).isOne();
  }

  @Test
  void shouldAddNewValueAtPositionOneToNonEmptyListAndReturnIncreasedSize() {
    // given
    DoubleLinkedList list = new DoubleLinkedList();
    int value1 = 1;
    list.add(value1);

    int value2 = 2;

    // when
    int result = list.add(value2,1);

    // then
    Assertions.assertThat(result).isEqualTo(2);
  }

  @Test
  void shouldThrowIllegalArgumentExceptionIfPositionIsGreaterThanSizeAndListIsNotEmpty(){
    // given
    DoubleLinkedList list = new DoubleLinkedList();
    int value1 = 1;
    list.add(value1);

    // when
    Throwable result = Assertions.catchThrowable(() -> list.add(7,99));

    // then
    Assertions.assertThat(result)
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Position must be less then or equal size");
  }

  @Test
  void shouldAddNewValueAtPositionTwoToNonEmptyListAndReturnSize3(){
    // given
    DoubleLinkedList list = new DoubleLinkedList();
    int value1 = 1;
    list.add(value1);
    int value2 = 2;
    list.add(value2);

    // when
    int result = list.add(3,2);
    String listAsString = list.toString();

    // then
    Assertions.assertThat(result).isEqualTo(3);
    Assertions.assertThat(listAsString).isEqualTo("1;3;2;");
  }
}

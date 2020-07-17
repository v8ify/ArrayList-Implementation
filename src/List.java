/**
 * List
 */
public class List<Type> {
  private Type[] values;
  private int firstFreeIndex;

  public List() {
    this.values = (Type[]) new Object[10];
    this.firstFreeIndex = 0;
  }

  public void add(Type value) {
    if (this.firstFreeIndex >= this.values.length) {
      this.grow();
    }

    this.values[this.firstFreeIndex] = value;
    this.firstFreeIndex++;
  }

  private void grow() {
    int newLength = this.values.length + this.values.length / 2;
    Type[] newArray = (Type[]) new Object[newLength];

    for (int i = 0; i < this.values.length; i++) {
      newArray[i] = this.values[i];
    }

    this.values = newArray;
  }

  public boolean contains(Object object) {
    for (int i = 0; i < this.firstFreeIndex; i++) {
      if (this.values[i].equals(object)) {
        return true;
      }
    }
    return false;
  }

  public void remove(Type value) {
    int indexOfValue = this.findIndexOfValue(value);
    if (indexOfValue < 0) {
      return;
    }
    this.moveListToLeft(indexOfValue);
  }

  private int findIndexOfValue(Type value) {
    for (int i = 0; i < this.firstFreeIndex; i++) {
      if (this.values[i].equals(value)) {
        return i;
      }
    }
    return -1;
  }

  private void moveListToLeft(int startIndex) {
    for (int i = startIndex; i < this.firstFreeIndex - 1; i++) {
      this.values[i] = this.values[i + 1];
    }
    this.firstFreeIndex--;
  }
}
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.tag.TodoTag;
import model.todolistitem.ITodoListItem;

public class TodoListModelImpl implements ITodoListModel {
  private final List<ITodoListItem> todoItems;

  public TodoListModelImpl() {
    this.todoItems = new ArrayList<>();
  }

  @Override
  public void addItems(ITodoListItem... toAdd) {
    for (ITodoListItem todo : toAdd) {
      todoItems.add(Utils.checkNotNull(todo, "cannot add a null todo item"));
    }
  }

  @Override
  public void deleteItems(ITodoListItem... toDelete)
  throws IllegalArgumentException {
    for (ITodoListItem todo : toDelete) {
      todoItems.remove(Utils.checkNotNull(todo, "cannot remove a null todo item"));
    }
  }

  @Override
  public void editItem(ITodoListItem toEdit, ITodoListItem newItem)
  throws IllegalArgumentException {
    if (!todoItems.contains(toEdit)) {
      throw new IllegalArgumentException("cannot edit an item that is not contained in the list");
    }
    todoItems.set(todoItems.indexOf(
        Utils.checkNotNull(toEdit, "cannot edit a null todo item")),
        Utils.checkNotNull(newItem, "cannot set the todo item to a null todo item"));
  }

  @Override
  public void swapItems(ITodoListItem swapper, ITodoListItem swapee)
  throws IllegalArgumentException {
    if (!todoItems.contains(swapper) || !todoItems.contains(swapee)) {
      throw new IllegalArgumentException("cannot swap items not contained in the list");
    }

    // fast solution
    if (swapper == swapee) {
      return;
    }

    todoItems.set(todoItems.indexOf(
        Utils.checkNotNull(swapper, "cannot swap a null list item")),
        Utils.checkNotNull(swapee, "cannot swap a null list item"));
    todoItems.set(todoItems.indexOf(
        swapee), // guaranteed not null
        swapper); // guaranteed not null
  }

  @Override
  public void sortBy(Comparator<ITodoListItem> comp) {
    Collections.sort(todoItems,
        Utils.checkNotNull(comp, "cannot sort a todo list by a null comparator"));
  }

  @Override
  public List<ITodoListItem> searchByTag(TodoTag toSortFor) {
    List<ITodoListItem> allSameTag = new ArrayList<>();

    for (ITodoListItem todo : todoItems) {
      if (todo.getTags().contains(toSortFor)) {
        allSameTag.add(todo);
      }
    }

    return allSameTag;
  }

  @Override
  public List<ITodoListItem> getItems() {
    return todoItems;
  }
}

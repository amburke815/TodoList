package model;

import java.util.Comparator;
import java.util.List;
import model.tag.TodoTag;
import model.todolistitem.ITodoListItem;

/**
 * TODO:
 * <ul>
 *   <li>add clock/calendar functionality for reminders and notifications</li>
 * </ul>
 */
public interface ITodoListModel {

  void addItems(ITodoListItem... toAdd);

  void deleteItems(ITodoListItem... toDelete)
      throws IllegalArgumentException;

  void editItem(ITodoListItem toEdit, ITodoListItem newItem)
      throws IllegalArgumentException;

  void swapItems(ITodoListItem swapper, ITodoListItem swapee)
      throws IllegalArgumentException;

  void sortBy(Comparator<ITodoListItem> comp);

  /**
   * TODO: possibly change signature to TodoTag...
   * @param toSortFor
   * @return
   */
  List<ITodoListItem> searchByTag(TodoTag toSortFor);

  List<ITodoListItem> getItems();

  // TODO
  // void notifyWhen(Notifier notifier);



}

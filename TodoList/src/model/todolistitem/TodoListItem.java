package model.todolistitem;

import java.util.ArrayList;
import java.util.List;
import model.Utils;
import model.date.TodoDate;
import model.tag.TodoTag;
import model.urgency.EUrgency;

public class TodoListItem implements ITodoListItem {

  private String description;
  private TodoDate creationDate;
  private TodoDate dueDate;
  private List<TodoTag> tags;
  private EUrgency urgency;
  private String notes;
  private List<ITodoListItem> subtasks;

  /**
   * Constructor to set the item to have medium urgency, no tags, and no notes, and no subtasks,
   * initialized to be non-null. At the very least, these arguments should be given upon creation:
   *
   * @param description
   * @param creationDate
   * @param dueDate
   */
  TodoListItem(String description, TodoDate creationDate, TodoDate dueDate) {
    this.description = Utils.constructorNotNull(description, "todo list item",
        "description");
    this.creationDate = Utils.constructorNotNull(creationDate, "todo list item",
        "creation date");
    this.dueDate = Utils.constructorNotNull(dueDate, "todo list item",
        "due date");
    this.tags = new ArrayList<>();
    this.urgency = EUrgency.MEDIUM;
    this.notes = "";
    this.subtasks = new ArrayList<>();
  }

  @Override
  public List<TodoTag> getTags() {
    return this.tags;
  }

// TODO: more constructors or implement builder pattern

}


package model.todolistitem;

import java.util.List;
import model.tag.TodoTag;

public interface ITodoListItem {

  List<TodoTag> getTags();
}

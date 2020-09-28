# User Guide

## Features 

### Add Task
This feature allows user to add a todo,an event or a deadline task into their List.

### Delete Task
This feature allows user to delete their desired todo,event and deadline they have previously entered

### Done Task
This feature allows user to mark their desired todo,event and deadline they have previously entered as done in the list

### Find Task
This feature allows user to search for their previously entered todo,event and deadline tasks

### List Task
This feature allows user to view all the todo,event and deadline they have previously entered

## Usage

### `todo` - Adds the todo task into the list

The todo part of the part can be interchange with deadline or event to add a deadline or an event respectively

Example of usage: 

`todo Sleep`
`event Sleep`
`deadline tomorrow`

Expected outcome:

-____________________________________________________________
-Got it. I've added this task: 
-	[T][✘] sleep
-Now you have 1 tasks in the list.
-____________________________________________________________

### `delete` - Delete a task at its index postition

The number 2 can be changed to any index the user wish to delete the task of.

Example of usage: 

`delete 2`

Expected outcome:

`outcome`

### `done ` - Mark the task at the index specified by the user as done in the list of tasks

The number 2 can be changed to any index the user wish to mark the task as done.

Example of usage: 

`done 2`

Expected outcome:

`outcome`

### `find` - Find task that contains the worsd that the user is searching

Returns the task names that has the term entered by the user 

Example of usage: 

`find return`

Expected outcome:

`outcome`

### `list` - Display all the task entered and its parameters

Display all the task entered by the user with the parameter (e.g. the done symbol and the type of task)

Example of usage: 

`list`

Expected outcome:

`outcome`


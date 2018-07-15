package app

import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import react.*
import react.dom.*
import logo.*
import model.Todo
import ticker.*
import util.value

class App : RComponent<RProps, App.State>() {

    init{
        state.todos = loadTodos()
    }

    fun loadTodos(): List<Todo>{
        return listOf(
        )
    }

    fun createTodo(todo: Todo){

        var oldTodos = state.todos

        setState {
            todos = oldTodos + todo
        }
    }

    fun removeTodo(todo: Todo){
        var oldTodos = state.todos
        setState {
            todos = oldTodos - todo
        }
    }

    override fun RBuilder.render() {
        section (classes = "todoapp") {
            headerInput(::createTodo)

            section (classes="main") {
                todoList(state.todos, ::removeTodo)
            }
        }
    }

    class State (var todos: List<Todo>) :RState
}

fun RBuilder.app() = child(App::class) {}

package com.example.ejercicio_alertdialogclon

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp



data class Tarea (
    val titulo: String,
    val completada: Boolean=false,
    val prioridad: String="Media"
)

@Composable

fun App3(){
    var tareas by remember {
        mutableStateOf(
            listOf(
                Tarea("Comprar pan", false, "Alta"),
                Tarea("Hacer la tarea", true, "Media"),
                Tarea("Llamar a mamá", false, "Baja")
            )
        )
    }

    Column (
        Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(10.dp)){

        Text(text = "Tareas pendientes")




        tareas.filter { !it.completada }.forEach { tarea ->
            TaskCard(tarea){
                    updatedTarea ->
                tareas = tareas.map { if (it == tarea) updatedTarea else it }
            }

        }

        Divider(color = Color.Gray)

        Text(text = "Tareas completadas")

        tareas.filter { it.completada }.forEach { tarea ->
            TaskCard(tarea){
                    updatedTarea ->
                tareas = tareas.map { if (it == tarea) updatedTarea else it }
            }

        }



    }

}

@Composable
fun TaskCard(
    tarea: Tarea,
    actualizartarea: (Tarea) -> Unit
) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(


        )
    ) {
        Row(
            Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BadgedBox(
                badge = {
                    Badge(
                        containerColor = when (tarea.prioridad) {
                            "Alta" -> Color.Red
                            "Media" -> Color.Yellow
                            else -> Color.Green
                        }
                    ) {

                     }
                }
            ) {Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)

            )}



            Spacer(Modifier.width(15.dp))


            Column(Modifier.weight(1f)) {
                Text(tarea.titulo)


            }



            var abrirmenu by remember { mutableStateOf(false) }



            Box {
                Button(onClick = { abrirmenu = true }) {
                    Text("Opciones")
                }




                DropdownMenu(
                    expanded = abrirmenu,
                    onDismissRequest = { abrirmenu = false }
                ) {
                    DropdownMenuItem(

                        text = { Text("Marcar completada") },
                        onClick = {
                            actualizartarea(tarea.copy(completada = !tarea.completada))
                            abrirmenu = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Prioridad  Alta") },
                        onClick = {
                            actualizartarea(tarea.copy(prioridad = "Alta"))
                            abrirmenu = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Prioridad Media") },
                        onClick = {
                            actualizartarea(tarea.copy(prioridad = "Media"))
                            abrirmenu = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Prioridad Baja") },
                        onClick = {
                            actualizartarea(tarea.copy(prioridad = "Baja"))
                            abrirmenu = false
                        }
                    )
                }
            }


        }
    }}


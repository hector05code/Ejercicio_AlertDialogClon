package com.example.ejercicio_alertdialogclon

import android.app.AlertDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)

@Composable

fun app01() {
    var openDialog by remember { mutableStateOf(0) }
    var displayText by remember { mutableStateOf("Presiona el botón para abrir la alerta") }
    var vertext by remember { mutableStateOf(false) }
    var textusuario by remember { mutableStateOf("Usuario") }
    var vertextr by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .systemBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Button(onClick = { openDialog = 1 },colors = ButtonDefaults.buttonColors( containerColor = Color.Red)) {
            Text("Mostrar Alerta")
        }

        Text(text = displayText)

        Button(onClick = { openDialog = 2 }) {
            Text("Alerta de Eliminación Permanente")
        }
        if (vertext) {
            Text(
                text = "Eliminacion exitosa",

                )
        }
        Button(onClick = { openDialog = 3 }) {
            Text("Alerta de Información Importante")
        }

        Button(onClick = { openDialog = 4 }) {
            Text("Alerta de Autenticación Requerida")
        }

        Text(text = textusuario)

        Button(onClick = { openDialog = 5 }) {
            Text("Alerta de Error Crítico")
        }
        if (vertextr) {
            Text(
                text = "Intento de Reintento",

                )
        }

        when(openDialog){
            1-> BasicAlertDialog(
                onDismissRequest = { openDialog = 0 },

                ){
                Surface(
                    modifier = Modifier.wrapContentWidth().wrapContentHeight(),
                    shape = MaterialTheme.shapes.large,
                    tonalElevation = AlertDialogDefaults.TonalElevation
                ){
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Confirmación de Acción")
                        Spacer(modifier = Modifier.height(15.dp))
                        Text("¿Estás seguro de que deseas continuar con esta acción?")

                        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                            TextButton(onClick = {
                                displayText = "Acción Confirmada"
                                openDialog = 0
                            }, modifier = Modifier.shadow(1.dp,shape = MaterialTheme.shapes.small)) {
                                Text("Sí")
                            }
                            Spacer(modifier = Modifier.width(30.dp))
                            TextButton(onClick = {
                                openDialog = 0
                            }, modifier = Modifier.shadow(1.dp,shape = MaterialTheme.shapes.small)) {
                                Text("No")
                            }
                        }

                    }
                }




            }

            2-> BasicAlertDialog(
                onDismissRequest = { openDialog = 0 },

                ){
                Surface(
                    modifier = Modifier.wrapContentWidth().wrapContentHeight(),
                    shape = MaterialTheme.shapes.large,
                    tonalElevation = AlertDialogDefaults.TonalElevation
                ){
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Eliminiar elemento")
                        Spacer(modifier = Modifier.height(15.dp))
                        Text("Esta acción es irreversible. ¿Deseas eliminar este elemento?")

                        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                            TextButton(onClick = {
                                vertext=true
                                openDialog = 0
                            }, modifier = Modifier.shadow(1.dp,shape = MaterialTheme.shapes.small)) {
                                Text("Eliminar")
                            }
                            Spacer(modifier = Modifier.width(30.dp))
                            TextButton(onClick = {
                                openDialog = 0
                            }, modifier = Modifier.shadow(1.dp,shape = MaterialTheme.shapes.small)) {
                                Text("Cancelar")
                            }
                        }

                    }
                }




            }
            3-> BasicAlertDialog(
                onDismissRequest = { openDialog = 0 },

                ){
                Surface(
                    modifier = Modifier.wrapContentWidth().wrapContentHeight(),
                    shape = MaterialTheme.shapes.large,
                    tonalElevation = AlertDialogDefaults.TonalElevation
                ){
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Aviso Importante")
                        Spacer(modifier = Modifier.height(15.dp))
                        Text("Recuerda que los cambios realizados no se pueden deshacer")

                        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                            TextButton(onClick = {
                                openDialog = 0
                            }, modifier = Modifier.shadow(1.dp,shape = MaterialTheme.shapes.small)) {
                                Text("Entendido")
                            }

                        }

                    }
                }




            }
            4-> BasicAlertDialog(
                onDismissRequest = { openDialog = 0 },

                ){
                Surface(
                    modifier = Modifier.wrapContentWidth().wrapContentHeight(),
                    shape = MaterialTheme.shapes.large,
                    tonalElevation = AlertDialogDefaults.TonalElevation
                ){
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Requiere Autenticación")
                        Spacer(modifier = Modifier.height(15.dp))
                        Text("Para continuar, necesitas autenticarte de nuevo")

                        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                            TextButton(onClick = {
                                textusuario = "Usuario Autenticado"
                                openDialog = 0
                            }, modifier = Modifier.shadow(1.dp,shape = MaterialTheme.shapes.small)) {
                                Text("Autenticar")
                            }
                            Spacer(modifier = Modifier.width(30.dp))
                            TextButton(onClick = {
                                openDialog = 0
                            }, modifier = Modifier.shadow(1.dp,shape = MaterialTheme.shapes.small)) {
                                Text("Cancelar")
                            }
                        }

                    }
                }




            }
            5-> BasicAlertDialog(
                onDismissRequest = { openDialog = 0 },

                ){
                Surface(  
                    modifier = Modifier.wrapContentWidth().wrapContentHeight(),
                    shape = MaterialTheme.shapes.large,
                    tonalElevation = AlertDialogDefaults.TonalElevation
                ){
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Error Crítico")
                        Spacer(modifier = Modifier.height(15.dp))
                        Text("Se ha producido un error crítico. ¿Deseas intentar nuevamente?")

                        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                            TextButton(onClick = {
                                openDialog = 0
                                vertextr=true
                            }, modifier = Modifier.shadow(1.dp,shape = MaterialTheme.shapes.small)) {
                                Text("Reintentar")
                            }
                            Spacer(modifier = Modifier.width(30.dp))
                            TextButton(onClick = {
                                openDialog = 0

                            }, modifier = Modifier.shadow(1.dp,shape = MaterialTheme.shapes.small)) {
                                Text("Cancelar")
                            }
                        }

                    }
                }




            }
        }


    }
}
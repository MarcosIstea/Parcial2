package com.example.parcial20.Precentacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ClimaView (
    modifier: Modifier = Modifier,
    estado:ClimaEstado,
    ejecutar: (ClimaIntencion)-> Unit

){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
            when(estado){
               is ClimaEstado.Cargando -> CargandoView()
                is ClimaEstado.Error -> ErrorView(estado.mensaje)
                is ClimaEstado.Exitoso -> ExitosoView(estado.clima)
                is ClimaEstado.Vacio -> VacioView()
            }
    }

}
@Composable
fun CargandoView() {
    Text("Cargando")
}

@Composable
fun ErrorView(mensaje: String) {
    Text(
        mensaje,
        style = MaterialTheme.typography.headlineLarge,
        color = MaterialTheme.colorScheme.error
    )
}
@Composable
fun ExitosoView(clima: Clima) {

}
@Composable
fun VacioView() {
    Text("No hay nada que mostrar")
}


@Preview(showBackground = true)
@Composable
fun ClimaViewCargando(){
    ClimaView(estado = ClimaEstado.Cargando){}
}

@Preview(showBackground = true)
@Composable
fun ClimaViewError(){
    ClimaView(estado = ClimaEstado.Error("fallo todo")){}
}

@Preview(showBackground = true)
@Composable
fun ClimaViewVacio(){
    ClimaView(estado = ClimaEstado.Vacio){}
}
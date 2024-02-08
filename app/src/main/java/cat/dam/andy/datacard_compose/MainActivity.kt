package cat.dam.andy.datacard_compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cat.dam.andy.datacard_compose.ui.theme.DataCard_composeTheme

class MainActivity : ComponentActivity() {
    // Obté les dades de l'objecte DataRepository,
    // així separem la lògica de negoci relacionada amb les dades
    // i la gestió de la lògica de la interfície d'usuari a l'aplicació.
    private val dataRepository = DataRepository()
    private val items: List<Item> by lazy { dataRepository.getDataItems() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DataCard_composeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Demo Card (Compose App)",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(8.dp)
                        )
                        ItemList(items)
                    }
                }
            }
        }
    }
}

@Composable
fun ItemList(itemList: List<Item>) {
    LazyColumn {
        items(itemList) { item ->
            ItemCard(item)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemCard(item: Item) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = {
            // Gestionar clic a la targeta
            Toast.makeText(context, "Has clicat a ${item.name}", Toast.LENGTH_SHORT).show()
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = item.imageResourceID),
                contentDescription = item.name,
                modifier = Modifier
                    .fillMaxHeight()  // Ocupa l'altura màxima disponible
                    .weight(0.40f)  // Ocupa el % de l'amplada
                    .clip(shape = MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.60f)  // Ocupa el % de l'amplada
            ) {
                Text(text = item.name, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = item.description, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "${item.price} €", style = MaterialTheme.typography.labelMedium)
            }
        }
    }
}



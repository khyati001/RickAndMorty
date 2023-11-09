package com.example.rickandmorty.compose

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.rickandmorty.R
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.model.Location
import com.example.rickandmorty.ui.theme.FeedAppTheme
import com.example.rickandmorty.viewmodel.CharacterViewModel

@Composable
fun Feed(characterViewModel: CharacterViewModel) {
    val characters by characterViewModel.characters.observeAsState(emptyList())
    val isLoading by characterViewModel.isLoading.observeAsState(false)

    FeedList(characters, isLoading)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FeedList(characters: List<Character>, isLoading: Boolean) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = { Text(stringResource(R.string.app_name)) }
            )
        }
    ) {
        LazyColumn(
            Modifier.fillMaxWidth(),
            state = rememberLazyListState(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(characters) { character ->
                CharacterItem(character)
            }
        }
    }
    if (isLoading) {
        CircularProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .wrapContentHeight(Alignment.CenterVertically)
                .width(64.dp),
            color = MaterialTheme.colors.secondary,
        )
    }
}

@Composable
fun CharacterItem(character: Character) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Spacer(modifier = Modifier.width(5.dp))
            Image(
                painter = rememberAsyncImagePainter(model = character.image),
                contentDescription = character.name,
                modifier = Modifier
                    .size(80.dp)
                    .padding(5.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Fit
            )
            Column(Modifier.padding(8.dp)) {
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onSurface,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Status: ${character.status}",
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = "Species: ${character.species}",
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onSurface
                )
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
@Composable
fun MyScreenPreview() {
    FeedAppTheme {
        FeedList(
            listOf(
                Character(
                    id = 1, name = "Rahul", status = "Alive", species = "Human",
                    type = "", gender = "Male", origin = Location("", ""),
                    location = Location("", ""), image = "", episode = listOf("1", "2"),
                    url = "", created = ""
                ),
                Character(
                    id = 2, name = "Sakshi", status = "Alive", species = "Human",
                    type = "", gender = "Female", origin = Location("", ""),
                    location = Location("", ""), image = "", episode = listOf("1", "2"),
                    url = "", created = ""
                )
            ), true
        )
    }
}
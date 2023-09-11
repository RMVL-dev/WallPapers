package com.example.wallpapers.ui.screens.categories

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.wallpapers.R
import com.example.wallpapers.model.data.categories.Category
import com.example.wallpapers.model.data.categories.categories
import com.example.wallpapers.ui.screens.images.ImagesViewModel
import com.example.wallpapers.utils.gradient


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
    viewModel: ImagesViewModel,
    navigateToImagesScreen: () -> Unit,
    context: Context = LocalContext.current
){
    var queryInput by remember {
        mutableStateOf("")
    }
    Column(modifier = modifier.fillMaxSize()) {
        Column (
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        ){
            OutlinedTextField(
                label = { Text(text = stringResource(id = R.string.query))},
                value =queryInput,
                onValueChange = {queryInput = it},
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                textStyle = MaterialTheme.typography.headlineSmall,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    focusedLabelColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    unfocusedLabelColor = Color.White
                )
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, end = 32.dp),
                onClick = {
                    viewModel.changeCategory(queryInput)
                    navigateToImagesScreen()
                          },
                contentPadding = PaddingValues(),
                colors = ButtonDefaults.buttonColors(contentColor = Color.Transparent),
                shape = RoundedCornerShape(30.dp)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = gradient,
                            shape = RoundedCornerShape(30.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.search).uppercase(),
                        color = Color.White,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }
        LazyColumn(modifier = modifier.fillMaxWidth()){
            items(categories){category: Category ->
                CategoryCard(
                    category = category,
                    onClick = {
                        viewModel.changeCategory(
                            category = context.getString(category.category)
                        )
                        navigateToImagesScreen()
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    category: Category,
    onClick: () -> Unit
){
    Card(
        modifier = modifier
            .height(100.dp)
            .padding(bottom = 10.dp, start = 5.dp, end = 5.dp),
        onClick = {
            onClick()
        }
    ){
        Box (
            modifier = modifier
            .fillMaxSize(),
            contentAlignment = Alignment.TopEnd
        ){
            Image(
                painter = painterResource(id = category.background),
                contentDescription = stringResource(id = category.category),
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize()
            )
            Text(
                text = stringResource(id = category.category).uppercase(),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

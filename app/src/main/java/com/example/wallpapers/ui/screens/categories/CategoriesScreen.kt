package com.example.wallpapers.ui.screens.categories

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wallpapers.model.data.categories.Category
import com.example.wallpapers.model.data.categories.categories
import com.example.wallpapers.ui.screens.images.ImagesViewModel


@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
    viewModel: ImagesViewModel,
    navigateToImagesScreen: () -> Unit,
    context: Context
){
    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn(modifier = modifier.fillMaxWidth()){
            items(categories){category: Category ->
                CategoryCard(
                    category = category,
                    onClick = {
                        viewModel.getListPhotos(
                            page = 1,
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
                fontSize = 25.sp,
                color = Color.White
            )
        }
    }
}

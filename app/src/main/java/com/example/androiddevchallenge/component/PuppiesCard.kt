/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.models.Puppie

@Composable
fun PuppiesCard(item: Puppie, onClick: (Puppie) -> Unit) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp,
            )
            .fillMaxWidth()
            .clickable(onClick = { onClick(item) }),
        elevation = 8.dp,
    ) {
        Row(modifier = Modifier.fillMaxSize()) {

            item.imgUrl?.let { imgUrl ->
                glideImage(url = imgUrl)?.let {
                    Card(
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .width(150.dp)
                            .height(150.dp)
                    ) {
                        Image(
                            bitmap = it.asImageBitmap(),
                            contentDescription = "",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()

                        )
                    }
                }
            }
            Column(modifier = Modifier.fillMaxSize()) {
                item.name?.let { name ->
                    Text(
                        text = name,
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 0.dp)
                    )
                }
                item.description?.let { description ->
                    Row(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "${if (description.length > 100) description.take(100) else description}.........",
                            color = MaterialTheme.colors.secondary,
                            modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 0.dp)
                        )
                    }
                }
            }
        }
    }
}

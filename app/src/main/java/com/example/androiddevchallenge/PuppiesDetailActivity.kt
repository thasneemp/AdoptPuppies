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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.component.glideImage
import com.example.androiddevchallenge.models.Puppie

class PuppiesDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoadData(
                puppie = Puppie(
                    intent.getStringExtra("name"),
                    description = intent.getStringExtra("description"),
                    imgUrl = intent.getStringExtra("imgUrl")
                )
            )
        }
    }
}

@Composable
fun LoadData(puppie: Puppie) {
    Column(Modifier.fillMaxSize()) {
        glideImage(url = puppie.imgUrl ?: "")?.let {
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth()
            )
        }
        puppie.name?.let { name ->
            Text(
                text = name,
                fontSize = 40.sp,
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(10.dp, 10.dp, 10.dp, 0.dp)
                    .fillMaxWidth()
            )
        }
        puppie.description?.let { description ->
            Row(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = description,
                    fontSize = 20.sp,
                    color = MaterialTheme.colors.secondary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 0.dp)
                )
            }
        }
    }
}

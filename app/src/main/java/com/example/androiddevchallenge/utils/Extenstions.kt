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
package com.example.androiddevchallenge.utils

import android.content.Context
import com.example.androiddevchallenge.models.Puppie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

fun Context.loadJSONFromAsset(): List<Puppie>? {
    val json: String? = try {
        val ins: InputStream = this.assets.open("puppies.json")
        val size: Int = ins.available()
        val buffer = ByteArray(size)
        ins.read(buffer)
        ins.close()
        String(buffer, Charset.defaultCharset())
    } catch (ex: IOException) {
        ex.printStackTrace()
        return null
    }

    return Gson().fromJson<List<Puppie>>(json, object : TypeToken<List<Puppie>>() {}.type)
}

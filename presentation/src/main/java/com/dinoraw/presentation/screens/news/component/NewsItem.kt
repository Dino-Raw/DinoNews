package com.dinoraw.presentation.screens.news.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dinoraw.domain.model.Articles

@Composable
fun NewsItem(
    article: Articles,
    onClick: (String, UriHandler) -> Unit,
    uriHandler: UriHandler = LocalUriHandler.current,
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = colorScheme.background),
        shape = MaterialTheme.shapes.extraSmall,
        onClick = { onClick(article.url!!, uriHandler) },
    ) {
        Column {
            article.title?.let { title ->
                Spacer(modifier = Modifier.padding(top = 4.dp))

                Text(
                    text ="$title.",
                    style = MaterialTheme.typography.titleMedium,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.SemiBold,
                    color = colorScheme.primary
                )

                Spacer(modifier = Modifier.padding(bottom = 4.dp))
            }

            article.description?.let { description ->
                Spacer(modifier = Modifier.padding(top = 4.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = FontFamily.Default,
                    color = colorScheme.secondary
                )

                Spacer(modifier = Modifier.padding(bottom = 4.dp))
            }

            article.urlToImage?.let { urlToImage ->
                Spacer(modifier = Modifier.padding(top = 12.dp))
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(urlToImage)
                        .crossfade(true)
                        .build(),
                    contentDescription = "News Item Image",
                    contentScale = ContentScale.Crop,
                )
                Spacer(modifier = Modifier.padding(bottom = 4.dp))
            }

            if (article.source != null || article.publishedAt != null) {
                Spacer(modifier = Modifier.padding(top = 4.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement =  Arrangement.SpaceBetween,
                ) {
                    article.source?.let { source -> source.name?.let { name ->
                        Text(
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(color = colorScheme.secondary)) {
                                    append("By ")
                                }
                                withStyle(style = SpanStyle(color = colorScheme.primary)) {
                                    append(name)
                                }

                            },
                            style = MaterialTheme.typography.bodySmall,
                            fontFamily = FontFamily.SansSerif,
                        )
                    } }

                    article.publishedAt?.let { publishedAt ->
                        Text(
                            text = publishedAt,
                            style = MaterialTheme.typography.bodySmall,
                            color = colorScheme.secondary
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(bottom = 4.dp))
            }

            Spacer(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
                    .height(0.2.dp)
                    .background(Color.LightGray)
            )
        }
    }
}
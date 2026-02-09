package org.company.app

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import firefox_slow.sharedui.generated.resources.Res
import org.company.app.theme.AppTheme
import kotlin.random.Random

@Preview
@Composable
fun App(
    onThemeChanged: @Composable (isDark: Boolean) -> Unit = {}
) = AppTheme(onThemeChanged) {
    val images = remember {
        List(100) {
            val p = it % 8 + 1
            if (p == 8) {
                Res.getUri("files/8.png")
            } else {
                Res.getUri("files/$p.jpeg")
            }
        }
    }
    LazyColumn {
        items(images.size) { index ->
            Column(
                modifier = Modifier.clickable { }
            ) {
                Card(modifier = Modifier.padding(16.dp).aspectRatio(16f / 9f)) {
                    AsyncImage(
                        model = images[index],
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = images[index].takeLast(10),
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Bold
                )

                val l = remember { text.length / Random.nextInt(1, 5) }
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = text.take(l),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

private const val text = """
    Shanty town weathered franchise j-pop office cartel camera katana jeans garage range-rover warehouse meta-nodal point. Dome long-chain hydrocarbons computer euro-pop pen semiotics bridge. Construct DIY tiger-team office futurity numinous drugs euro-pop rain weathered shrine disposable woman soul-delay drone spook. Sentient digital gang 3D-printed denim long-chain hydrocarbons garage euro-pop bridge fetishism office. Decay construct neural convenience store urban ablative silent wonton soup crypto-market shrine bomb.
"""

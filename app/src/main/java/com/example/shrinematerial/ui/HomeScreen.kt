package com.example.shrinematerial.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shrinematerial.R
import com.example.shrinematerial.data.Retail
import com.example.shrinematerial.data.RetailItems
import com.example.shrinematerial.ui.theme.*

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(ShrinePink100)
            .fillMaxSize()
    ) {
        Column {
            ShrineBottomSheet()
            ShrineMiddleSheet()
        }
    }
}

@Composable
private fun ShrineBottomSheet() {
    Row {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = "navigation drawer",
                    tint = DarkShrinePink900,
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_shrine_logo),
                    contentDescription = "Shrine Logo",
                    tint = DarkShrinePink900
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "SHRINE", style = MaterialTheme.typography.subtitle1,
                    color = DarkShrinePink900
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_search_24),
                contentDescription = "search",
                tint = DarkShrinePink900,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
    }
}

@Composable
fun ShrineMiddleSheet() {
    Surface(elevation = 16.dp, shape = MaterialTheme.shapes.large) {
        Column(
            modifier = Modifier
                .background(ShrineWhiteBg)
                .fillMaxWidth()
        ) {
            HorizontalGridSection()
        }
    }
}

@Composable
fun HorizontalGridSection(retails: List<Retail> = RetailItems) {
    Box(Modifier.fillMaxSize()) {
        BoxWithConstraints(
            Modifier
                .fillMaxSize()
                .padding(start = 16.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            val gridGutter = 16.dp
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(gridGutter)
            ) {
                var idx = 0
                while (idx < retails.size) {
                    val even = idx % 3 == 0
                    if (even) {
                        Column(
                            Modifier
                                .fillMaxHeight()
                                .width(this@BoxWithConstraints.minWidth * 0.66f),
                            verticalArrangement = Arrangement.Center
                        ) {
                            RetailCard(
                                retail = retails[idx], modifier = Modifier
                                    .align(Alignment.End)
                                    .fillMaxWidth(0.85f)
                            )
                            if (retails.getOrNull(idx + 1) != null) {
                                Spacer(Modifier.height(32.dp))
                                RetailCard(
                                    retail = retails[idx + 1],
                                    modifier = Modifier.fillMaxWidth(0.85f),
                                )
                            }
                        }
                    } else {
                        Column(
                            Modifier
                                .fillMaxHeight()
                                .width(this@BoxWithConstraints.minWidth * 0.66f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            RetailCard(
                                retail = retails[idx],
                                isVertical = true,
                                modifier = Modifier.fillMaxWidth(0.8f),
                            )
                        }
                    }
                    idx += if (even) 2 else 1
                }
                Spacer(Modifier.width(gridGutter))
            }
        }
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.TopEnd)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_tune),
                contentDescription = "Filter",
                tint = DarkShrinePink900,
            )
        }
        ShrineTopSheet(modifier = Modifier.align(Alignment.BottomEnd))
    }
}


@Composable
fun RetailCard(modifier: Modifier = Modifier, retail: Retail, isVertical: Boolean = false) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Box {
            Image(
                painter = painterResource(id = retail.productImgIdRes),
                contentDescription = retail.productName,
                contentScale = if (isVertical) ContentScale.FillHeight else ContentScale.FillWidth,
                modifier = if (isVertical) Modifier.fillMaxHeight(0.4f) else Modifier
                    .fillMaxWidth()
                    .heightIn(max = 220.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_add_shopping_cart_24),
                contentDescription = "Add to Cart",
                tint = DarkShrinePink900,
                modifier = Modifier.padding(12.dp)
            )
            Image(
                painter = painterResource(id = retail.brandIconIdRes),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = 12.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        RetailText(
            text = retail.productName,
            style = MaterialTheme.typography.subtitle2
        )
        RetailText(
            text = "$${retail.price}",
            style = MaterialTheme.typography.caption
        )
    }
}

@Composable
private fun RetailText(modifier: Modifier = Modifier, text: String, style: TextStyle) {
    Text(
        text = text,
        color = DarkShrinePink900,
        style = style,
    )
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun ShrineTopSheet(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        elevation = 18.dp,
        shape = CutCornerShape(topStart = 24.dp),
        ) {
        Box(
            modifier = modifier
                .background(ShrinePink50)
                .width(72.dp)
                .size(56.dp)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_shopping_cart_24),
                contentDescription = "Shopping Cart",
                tint = DarkShrinePink900,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    ShrineMaterialTheme {
        HomeScreen()
    }
}
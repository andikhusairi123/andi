package ark.coding.grocery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andi_khusairi.R
import com.example.andi_khusairi.ui.theme.andikhusairiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun MainTheme(content: @Composable () -> Unit) {
    andikhusairiTheme() {


        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainTheme {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {
    Box(Modifier.verticalScroll(rememberScrollState())) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, (-30).dp),
            painter = painterResource(id = R.drawable.bg_main),
            contentDescription = "Header Background",
            contentScale = ContentScale.FillWidth
        )
        Column {
            AppBar()
            Content()
        }
    }
}

@Composable
fun AppBar() {
    Row(
        Modifier
            .padding(16.dp)
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Jaket Hoddy.", fontSize = 12.sp) },
            singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Rounded.Search, contentDescription = "") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        )
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = { }) {
            Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "", tint = Color.White)
        }
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "", tint = Color.White)
        }
    }
}

@Composable
fun Content() {
    Column() {
        Header()
        Spacer(modifier = Modifier.height(16.dp))
        Promotions()
        Spacer(modifier = Modifier.height(16.dp))
        CategorySection()
        Spacer(modifier = Modifier.height(16.dp))
        BestSellerSection()
    }
}

@Composable
fun Header() {
    Card(
        Modifier
            .height(64.dp)
            .padding(horizontal = 16.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            VerticalDivider()
            Row(Modifier
                .fillMaxHeight()
                .weight(1f)
                .clickable { }
                .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(id = R.drawable.uang), contentDescription = "", tint = Color(0xFF6FCF97))
                Column(Modifier.padding(8.dp)) {
                    Text(text = "Rp 0", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "Saldo", color = MaterialTheme.colors.primary, fontSize = 12.sp)
                }
            }

            VerticalDivider()
            Row(Modifier
                .fillMaxHeight()
                .weight(1f)
                .clickable { }
                .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(id = R.drawable.uang), contentDescription = "", tint = MaterialTheme.colors.primary)
                Column(Modifier.padding(8.dp)) {
                    Text(text = "10.000", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "Bonus", color = Color.LightGray, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
fun VerticalDivider() {
    Divider(
        color = Color(0xFFF1F1F1),
        modifier = Modifier
            .width(1.dp)
            .height(32.dp)
    )
}

@Composable
fun Promotions() {
    LazyRow(
        Modifier.height(160.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.jaketpremium),
                title = "Jaket",
                subtitle = "Premiun",
                header = "80%",
                backgroundColor = MaterialTheme.colors.primary
            )
        }
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.jaket1),
                title = "Jaket",
                subtitle = "Kulit",
                header = "50%",
                backgroundColor = Color(0xff6EB6F5)
            )
        }
    }
}

@Composable
fun PromotionItem(
    title: String = "",
    subtitle: String = "",
    header: String = "",
    backgroundColor: Color = Color.Transparent,
    imagePainter: Painter
) {
    Card(
        Modifier.width(300.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = backgroundColor,
        elevation = 0.dp
    ) {
        Row {
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = title, fontSize = 14.sp, color = Color.White)
                Text(text = subtitle, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text(text = header, fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun CategorySection() {
    Column(Modifier.padding(horizontal = 16.dp)) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Produk", style = MaterialTheme.typography.h6)
            TextButton(onClick = {}) {
                Text(text = "Lainnya", color = MaterialTheme.colors.primary)
            }
        }

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryButton(
                text = "Switer",
                icon = painterResource(id = R.drawable.jaket1),
                backgroundColor = Color(0xffFEF4E7)
            )
            CategoryButton(
                text = "Kulit",
                icon = painterResource(id = R.drawable.jaket2),
                backgroundColor = Color(0xffF6FBF3)
            )
            CategoryButton(
                text = "levis",
                icon = painterResource(id = R.drawable.jaket3),
                backgroundColor = Color(0xffFFFBF3)
            )
            CategoryButton(
                text = "Hoddy",
                icon = painterResource(id = R.drawable.jaket4),
                backgroundColor = Color(0xffF6E6E9)
            )
        }
    }
}

@Composable
fun CategoryButton(
    text: String = "",
    icon: Painter,
    backgroundColor: Color
) {
    Column(
        Modifier
            .width(72.dp)
            .clickable { }
    ) {
        Box(
            Modifier
                .size(72.dp)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(18.dp)
        ) {
            Image(painter = icon, contentDescription = "", modifier = Modifier.fillMaxSize())
        }
        Text(text = text, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 12.sp)
    }
}

@Composable
fun BestSellerSection() {
    Column() {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Pilihan", style = MaterialTheme.typography.h6)
            TextButton(onClick = {}) {
                Text(text = "Lainnya", color = MaterialTheme.colors.primary)
            }
        }

        BestSellerItems()
    }
}

@Composable
fun BestSellerItems() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.jaket1),
                title = "Kulit",
                price = "Rp 10.000",
                discountPercent = 50%
            )
        }
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.jaket2),
                title = "Switter",
                price = "20.000",
                discountPercent = 10%
            )
        }
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.jaket3),
                title = "Meat",
                price = "4.76",
                discountPercent = 20
            )
        }
    }
}

@Composable
fun BestSellerItem(
    title: String = "",
    price: String = "",
    discountPercent: Int = 0,
    imagePainter: Painter
) {
    Card(
        Modifier
            .width(160.dp)
    ) {
        Column(
            Modifier
                .padding(bottom = 32.dp)
        ) {
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Text(text = title, fontWeight = FontWeight.Bold)
                Row {
                    Text(
                        "$${price}",
                        textDecoration = if (discountPercent > 0)
                            TextDecoration.LineThrough
                        else
                            TextDecoration.None,
                        color = if (discountPercent > 0) Color.Gray else Color.Black
                    )
                    if (discountPercent > 0) {
                        Text(text = "[$discountPercent%]", color = MaterialTheme.colors.primary)
                    }
                }
            }
        }
    }
}
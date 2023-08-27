package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFD2E8D4)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))
        ProfileInfo(
            imageId = R.drawable.android_logo,
            name = "Miwarkop",
            title = "Android Developer"
        )
        Spacer(Modifier.weight(1f))
        ContactInfoCard()
        Spacer(Modifier)
    }
}

@Composable
fun ProfileInfo(
    imageId: Int,
    name: String,
    title: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(imageId)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = "Android Image",
            Modifier
                .background(Color(0xFF073042))
                .width(120.dp)
                .padding(16.dp)
        )
        Text(
            text = name,
            fontSize = 32.sp,
            modifier = Modifier.padding(
                top = 4.dp,
                bottom = 8.dp
            )
        )
        Text(
            text = title,
            color = Color(0xFF006C39),
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}

@Composable
fun ContactInfoCard() {
    Column {
        ContactInfo(
            icon = Icons.Filled.Call,
            text = "+628 123 456 789",
            category = "Phone Number"
        )
        ContactInfo(
            icon = Icons.Filled.Share,
            text = "@miwarkop",
            category = "Social Media"
        )
        ContactInfo(
            icon = Icons.Filled.Email,
            text = "miwarkop@email.com",
            category = "Email",
            Modifier.padding(bottom = 32.dp)
        )

    }
}

@Composable
fun ContactInfo(
    icon: ImageVector,
    text: String,
    category: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier.padding(bottom = 16.dp)
    ) {
        Icon(
            icon,
            contentDescription = "$category Icon",
            tint = Color(0xFF006C39),
            modifier = Modifier.size(20.dp)
        )
        Text(
            text,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Busine() {
    BusinessCardTheme {
        BusinessCard()
    }
}
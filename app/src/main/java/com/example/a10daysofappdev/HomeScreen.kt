package com.example.a10daysofappdev.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a10daysofappdev.data.DataSource
import com.example.a10daysofappdev.model.Day
import com.example.compose.AppTheme

@Composable
fun DayCard(
    day: Day,
    modifier: Modifier = Modifier
) {
    Card() {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Day: ${day.day}",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(day.title)
            )
            Image(
                painter = painterResource(day.image),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview
@Composable
fun DayCardPreview() {
    AppTheme {
        DayCard(day = DataSource.days[0])
    }
}
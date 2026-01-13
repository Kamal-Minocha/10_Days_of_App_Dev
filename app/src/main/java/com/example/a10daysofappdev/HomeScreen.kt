package com.example.a10daysofappdev.ui.theme

import android.R.attr.onClick
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a10daysofappdev.data.DataSource
import com.example.a10daysofappdev.data.DataSource.days
import com.example.a10daysofappdev.model.Day
import com.example.compose.AppTheme

@Composable
fun DayCard(
    day: Day,
    isExpanded: Boolean,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {

//    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .clickable(onClick = onCardClick)
    ) {
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            AnimatedVisibility(visible = isExpanded) {
                Text(
                    text = stringResource(day.description), // Assuming Day data class has a description field
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 8.dp) // Add some padding above description
                )
            }

        }
    }
}

@Composable
fun DayList(
    days: List<Day>,
    modifier: Modifier = Modifier
) {

    var expandedDay by remember { mutableStateOf<Int?>(null) }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        items(days) { day ->
            DayCard(day = day,
                isExpanded = (expandedDay == day.day),
                onCardClick = {
                    expandedDay = if (expandedDay == day.day) { null }
                    else { day.day }
                },
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun DayCardPreview() {
    AppTheme {
        DayList(days = days)
    }
}
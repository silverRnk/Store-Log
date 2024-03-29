package com.example.sari_saristorelog.feature_transaction_log.presentation.AddEditTransaction.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sari_saristorelog.R

@Composable
fun CustomerInfoForm(
    @DrawableRes customerIcon: Int,
    customerName: String,
    onNameChange: (String) -> Unit,
    onToggleIconSelection: () -> Unit,
    modifier: Modifier = Modifier
){

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        
        Box(modifier = Modifier
            .wrapContentSize()
            .clip(CircleShape)
            .clickable { onToggleIconSelection() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_left_15),
                contentDescription = "ToggleIcon",
                modifier = Modifier.size(25.dp))
        }

        Box(modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
            .background(Color.White)
            .border(width = 1.dp, Color.Black, shape = CircleShape)){

            Image(
                painter = painterResource(id = customerIcon),
                contentDescription = "CustomerIcon",
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier
                    .matchParentSize()
                    .clip(CircleShape)
                    .align(Alignment.Center))
        }

        Spacer(modifier = Modifier.width(15.dp))

        Column(horizontalAlignment = Alignment.Start) {
            Text(text = "Name:",
                style = MaterialTheme.typography.h3,
                fontSize = 18.sp )

            Spacer(modifier = Modifier.height(2.dp))

            NameTextField(
                text = customerName,
                onValueChange = {onNameChange(it)})
        }

    }


}
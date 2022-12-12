package com.example.sari_saristorelog.feature_transaction_log.presentation.AddEditTransaction.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sari_saristorelog.R
import com.example.sari_saristorelog.feature_transaction_log.domain.model.Items

@Composable
fun CustomerInfoFill(
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

        Icon(
            painter = painterResource(id = customerIcon),
            contentDescription = "CustomerIcon",
            modifier = Modifier.size(60.dp))

        Spacer(modifier = Modifier.width(15.dp))

        Column(horizontalAlignment = Alignment.Start) {
            Text(text = "Name:",
                style = MaterialTheme.typography.h3,
                fontSize = 15.sp )

            Spacer(modifier = Modifier.height(2.dp))

            NameTextField(
                text = customerName,
                onValueChange = {onNameChange(it)})
        }

    }


}
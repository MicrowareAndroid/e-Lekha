import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.psc.elekha.ui.theme.appleblue
import com.psc.elekha.ui.theme.lightblues
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.roboto_regular
import org.jetbrains.compose.resources.Font

@Composable
fun KycTabItem(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(width = 120.dp, height = 35.dp)
            .background(
                if (selected) appleblue else lightblues,
                RoundedCornerShape(20.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            maxLines = 1,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(Res.font.roboto_regular)),
            color = if (selected) Color.White else Color.Black
        )
    }
}

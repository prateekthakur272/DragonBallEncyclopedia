package dev.prateekthakur.dragonballencyclopedia.ui.screens.characterdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.prateekthakur.dragonballencyclopedia.ui.composables.InfoChip
import dev.prateekthakur.dragonballencyclopedia.ui.composables.NetworkImage
import dev.prateekthakur.dragonballencyclopedia.ui.utils.Space

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun CharacterDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: CharacterDetailsViewModel = hiltViewModel()
) {

    val character by viewModel.character.collectAsState()

    val appBar = @Composable {
        TopAppBar(
            title = {
                Text(character!!.name)
            }
        )
    }

    if (character != null)
        Scaffold(
            topBar = appBar
        ) { scaffoldPadding ->
            Box(modifier = modifier.padding(scaffoldPadding)) {
                Column(
                    modifier = modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {

                    character?.let {
                        Box(contentAlignment = Alignment.BottomCenter) {
                            Box(
                                modifier = modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(24.dp))
                                    .height(100.dp)
                                    .background(Color.Gray.copy(alpha = 0.5f))
                            )

                            NetworkImage(
                                it.image!!, modifier = modifier
                                    .height(360.dp)
                                    .padding(bottom = 16.dp)
                            )
                        }
                        24.Space()
                        Text(
                            "${it.name} - ${it.affiliation}",
                            style = MaterialTheme.typography.titleLarge
                        )
                        8.Space()
                        FlowRow(
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            InfoChip(it.race!!)
                            InfoChip(it.gender!!)
                        }
                        8.Space()
                        Text(
                            it.description.toString(),
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Justify
                        )

                        HorizontalDivider(modifier = modifier.padding(vertical = 16.dp))
                    }

                    character!!.originPlanet?.let {
                        Text(
                            "Origin Planet - ${it.name}",
                            style = MaterialTheme.typography.titleLarge
                        )
                        16.Space()
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = modifier.fillMaxWidth()
                        ) {
                            NetworkImage(it.image, cornerRadius = 16, modifier = modifier
                                .height(200.dp)
                                .clickable { })
                        }
                    }

                    24.Space()

                    character!!.transformations.let { transformations ->
                        HorizontalPager(
                            state = rememberPagerState { transformations.size }
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = modifier.fillMaxWidth()
                            ) {
                                DragonBallCharacterTransformationView(transformations[it])
                                Box(
                                    modifier = modifier.matchParentSize(),
                                    contentAlignment = Alignment.TopEnd
                                ) {
                                    Box(
                                        modifier = modifier
                                            .padding(16.dp)
                                            .clip(RoundedCornerShape(16.dp))
                                            .background(Color.Gray).padding(
                                            horizontal = 8.dp,
                                            vertical = 4.dp
                                        )
                                    )
                                    {
                                        Text("${it+1}/${transformations.size}")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
}

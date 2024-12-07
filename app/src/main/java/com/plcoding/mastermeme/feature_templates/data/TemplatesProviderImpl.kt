package com.plcoding.mastermeme.feature_templates.data

import android.net.Uri
import com.plcoding.mastermeme.core.domain.value.ImageLocation
import com.plcoding.mastermeme.core.domain.value.TemplateName
import com.plcoding.mastermeme.feature_templates.domain.TemplateData

class TemplatesProviderImpl : TemplatesProvider {


    override fun getAllTemplates(): List<TemplateData> {
        return templateData
    }

    private val templateData = listOf(
        "1 Disaster-Girl.jpg",
        "2 Epic-Handshake.jpg",
        "3 Left-Exit-12-Off-Ramp.jpg",
        "4 Sad-Pablo-Escobar.jpg",
        "5. Change-My-Mind.jpg",
        "6. Two-Buttons.jpg",
        "7. Hide-the-Pain-Harold.jpg",
        "8. The-Rock-Driving.jpg",
        "9 (1) Grus-Plan.jpg",
        "10. I-Bet-Hes-Thinking-About-Other-Women.jpg",
        "11. Third-World-Skeptical-Kid.jpg",
        "12 3eqjd8.jpg",
        "13. 43iacv.jpg",
        "14 Running-Away-Balloon.jpg",
        "15 24zoa8.jpg",
        "16 3f0mvv.jpg",
        "17 2w2e5e.png",
        "18 64sz4u.png",
        "19 6u6ylb.png",
        "20 3x8soh.jpg",
        "21 Is-This-A-Pigeon.jpg",
        "22 1yz6z4.jpg",
        "23 Jack-Sparrow-Being-Chased.jpg",
        "24 Leonardo-Dicaprio-Cheers.jpg",
        "25 1op9wy.jpg",
        "26 2t8r9a.png",
        "27 34vt4i.jpg",
        "28 Two-Buttons.jpg",
        "29 2bbctk.jpg",
        "30 8c9dbh.jpg",
        "31 Clown-Applying-Makeup.jpg",
        "32 2eb198.jpg",
        "33 2byuiy.jpg",
        "34 Scared-Cat.jpg",
        "35 I-Was-Told-There-Would-Be.jpg",
        "36 Boardroom-Meeting-Suggestion.jpg",
        "38 14p2is.jpg",
        "39 6rcrc1.jpeg",
        "40 1otri4.jpg",
        "41 49su9f.png",
        "42 7wxtd1.png",
        "43 Waiting-Skeleton.jpg",
        "44 1jgrgn.jpg",
        "45 58eyvu.png",
        "46 21ajtl.jpg",
        "47 3igo27.png",
        "48 59c1hh.png",
        "49 2qx7sw.jpg",
        "50 2reqtg.png"
    ).map { fileName ->
        TemplateData(
            name = TemplateName(fileName),
            imageLocation = ImageLocation(Uri.parse("$TEMPLATES_FOLDER$fileName"))
        )
    }

    companion object {
        const val TEMPLATES_FOLDER = "meme-templates/"
    }
}

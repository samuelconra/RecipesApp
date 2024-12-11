package com.samuelconra.recipesapp.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val BookmarkFilled: ImageVector
    get() {
        if (_BookmarkFilled != null) {
            return _BookmarkFilled!!
        }
        _BookmarkFilled = ImageVector.Builder(
            name = "BookmarkFilled",
            defaultWidth = 15.dp,
            defaultHeight = 15.dp,
            viewportWidth = 15f,
            viewportHeight = 15f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(3.5f, 2f)
                curveTo(3.2239f, 2f, 3f, 2.2239f, 3f, 2.5f)
                verticalLineTo(13.5f)
                curveTo(3f, 13.6818f, 3.0986f, 13.8492f, 3.2576f, 13.9373f)
                curveTo(3.4166f, 14.0254f, 3.6109f, 14.0203f, 3.765f, 13.924f)
                lineTo(7.5f, 11.5896f)
                lineTo(11.235f, 13.924f)
                curveTo(11.3891f, 14.0203f, 11.5834f, 14.0254f, 11.7424f, 13.9373f)
                curveTo(11.9014f, 13.8492f, 12f, 13.6818f, 12f, 13.5f)
                verticalLineTo(2.5f)
                curveTo(12f, 2.2239f, 11.7761f, 2f, 11.5f, 2f)
                horizontalLineTo(3.5f)
                close()
            }
        }.build()
        return _BookmarkFilled!!
    }

private var _BookmarkFilled: ImageVector? = null

public val Bookmark: ImageVector
    get() {
        if (_Bookmark != null) {
            return _Bookmark!!
        }
        _Bookmark = ImageVector.Builder(
            name = "Bookmark",
            defaultWidth = 15.dp,
            defaultHeight = 15.dp,
            viewportWidth = 15f,
            viewportHeight = 15f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(3f, 2.5f)
                curveTo(3f, 2.2239f, 3.2239f, 2f, 3.5f, 2f)
                horizontalLineTo(11.5f)
                curveTo(11.7761f, 2f, 12f, 2.2239f, 12f, 2.5f)
                verticalLineTo(13.5f)
                curveTo(12f, 13.6818f, 11.9014f, 13.8492f, 11.7424f, 13.9373f)
                curveTo(11.5834f, 14.0254f, 11.3891f, 14.0203f, 11.235f, 13.924f)
                lineTo(7.5f, 11.5896f)
                lineTo(3.765f, 13.924f)
                curveTo(3.6109f, 14.0203f, 3.4166f, 14.0254f, 3.2576f, 13.9373f)
                curveTo(3.0986f, 13.8492f, 3f, 13.6818f, 3f, 13.5f)
                verticalLineTo(2.5f)
                close()
                moveTo(4f, 3f)
                verticalLineTo(12.5979f)
                lineTo(6.97f, 10.7416f)
                curveTo(7.2943f, 10.539f, 7.7057f, 10.539f, 8.03f, 10.7416f)
                lineTo(11f, 12.5979f)
                verticalLineTo(3f)
                horizontalLineTo(4f)
                close()
            }
        }.build()
        return _Bookmark!!
    }

private var _Bookmark: ImageVector? = null


public val ChevronLeft: ImageVector
    get() {
        if (_ChevronLeft != null) {
            return _ChevronLeft!!
        }
        _ChevronLeft = ImageVector.Builder(
            name = "ChevronLeft",
            defaultWidth = 15.dp,
            defaultHeight = 15.dp,
            viewportWidth = 15f,
            viewportHeight = 15f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(8.84182f, 3.13514f)
                curveTo(9.0433f, 3.324f, 9.0535f, 3.6404f, 8.8646f, 3.8419f)
                lineTo(5.43521f, 7.49991f)
                lineTo(8.86462f, 11.1579f)
                curveTo(9.0535f, 11.3594f, 9.0433f, 11.6758f, 8.8418f, 11.8647f)
                curveTo(8.6404f, 12.0535f, 8.3239f, 12.0433f, 8.1351f, 11.8419f)
                lineTo(4.38508f, 7.84188f)
                curveTo(4.2048f, 7.6495f, 4.2048f, 7.3503f, 4.3851f, 7.1579f)
                lineTo(8.13508f, 3.15794f)
                curveTo(8.3239f, 2.9565f, 8.6404f, 2.9463f, 8.8418f, 3.1351f)
                close()
            }
        }.build()
        return _ChevronLeft!!
    }

private var _ChevronLeft: ImageVector? = null


public val Lock: ImageVector
    get() {
        if (_Lock != null) {
            return _Lock!!
        }
        _Lock = ImageVector.Builder(
            name = "Lock",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(240f, 880f)
                quadToRelative(-33f, 0f, -56.5f, -23.5f)
                reflectiveQuadTo(160f, 800f)
                verticalLineToRelative(-400f)
                quadToRelative(0f, -33f, 23.5f, -56.5f)
                reflectiveQuadTo(240f, 320f)
                horizontalLineToRelative(40f)
                verticalLineToRelative(-80f)
                quadToRelative(0f, -83f, 58.5f, -141.5f)
                reflectiveQuadTo(480f, 40f)
                reflectiveQuadToRelative(141.5f, 58.5f)
                reflectiveQuadTo(680f, 240f)
                verticalLineToRelative(80f)
                horizontalLineToRelative(40f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(800f, 400f)
                verticalLineToRelative(400f)
                quadToRelative(0f, 33f, -23.5f, 56.5f)
                reflectiveQuadTo(720f, 880f)
                close()
                moveToRelative(0f, -80f)
                horizontalLineToRelative(480f)
                verticalLineToRelative(-400f)
                horizontalLineTo(240f)
                close()
                moveToRelative(240f, -120f)
                quadToRelative(33f, 0f, 56.5f, -23.5f)
                reflectiveQuadTo(560f, 600f)
                reflectiveQuadToRelative(-23.5f, -56.5f)
                reflectiveQuadTo(480f, 520f)
                reflectiveQuadToRelative(-56.5f, 23.5f)
                reflectiveQuadTo(400f, 600f)
                reflectiveQuadToRelative(23.5f, 56.5f)
                reflectiveQuadTo(480f, 680f)
                moveTo(360f, 320f)
                horizontalLineToRelative(240f)
                verticalLineToRelative(-80f)
                quadToRelative(0f, -50f, -35f, -85f)
                reflectiveQuadToRelative(-85f, -35f)
                reflectiveQuadToRelative(-85f, 35f)
                reflectiveQuadToRelative(-35f, 85f)
                close()
                moveTo(240f, 800f)
                verticalLineToRelative(-400f)
                close()
            }
        }.build()
        return _Lock!!
    }

private var _Lock: ImageVector? = null

public val Construction: ImageVector
    get() {
        if (_Construction != null) {
            return _Construction!!
        }
        _Construction = ImageVector.Builder(
            name = "Construction",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(756f, 840f)
                lineTo(537f, 621f)
                lineToRelative(84f, -84f)
                lineToRelative(219f, 219f)
                close()
                moveToRelative(-552f, 0f)
                lineToRelative(-84f, -84f)
                lineToRelative(276f, -276f)
                lineToRelative(-68f, -68f)
                lineToRelative(-28f, 28f)
                lineToRelative(-51f, -51f)
                verticalLineToRelative(82f)
                lineToRelative(-28f, 28f)
                lineToRelative(-121f, -121f)
                lineToRelative(28f, -28f)
                horizontalLineToRelative(82f)
                lineToRelative(-50f, -50f)
                lineToRelative(142f, -142f)
                quadToRelative(20f, -20f, 43f, -29f)
                reflectiveQuadToRelative(47f, -9f)
                reflectiveQuadToRelative(47f, 9f)
                reflectiveQuadToRelative(43f, 29f)
                lineToRelative(-92f, 92f)
                lineToRelative(50f, 50f)
                lineToRelative(-28f, 28f)
                lineToRelative(68f, 68f)
                lineToRelative(90f, -90f)
                quadToRelative(-4f, -11f, -6.5f, -23f)
                reflectiveQuadToRelative(-2.5f, -24f)
                quadToRelative(0f, -59f, 40.5f, -99.5f)
                reflectiveQuadTo(701f, 119f)
                quadToRelative(15f, 0f, 28.5f, 3f)
                reflectiveQuadToRelative(27.5f, 9f)
                lineToRelative(-99f, 99f)
                lineToRelative(72f, 72f)
                lineToRelative(99f, -99f)
                quadToRelative(7f, 14f, 9.5f, 27.5f)
                reflectiveQuadTo(841f, 259f)
                quadToRelative(0f, 59f, -40.5f, 99.5f)
                reflectiveQuadTo(701f, 399f)
                quadToRelative(-12f, 0f, -24f, -2f)
                reflectiveQuadToRelative(-23f, -7f)
                close()
            }
        }.build()
        return _Construction!!
    }

private var _Construction: ImageVector? = null


public val Timer: ImageVector
    get() {
        if (_Timer != null) {
            return _Timer!!
        }
        _Timer = ImageVector.Builder(
            name = "Timer",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(360f, 120f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(240f)
                verticalLineToRelative(80f)
                close()
                moveToRelative(80f, 440f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(-240f)
                horizontalLineToRelative(-80f)
                close()
                moveToRelative(40f, 320f)
                quadToRelative(-74f, 0f, -139.5f, -28.5f)
                reflectiveQuadTo(226f, 774f)
                reflectiveQuadToRelative(-77.5f, -114.5f)
                reflectiveQuadTo(120f, 520f)
                reflectiveQuadToRelative(28.5f, -139.5f)
                reflectiveQuadTo(226f, 266f)
                reflectiveQuadToRelative(114.5f, -77.5f)
                reflectiveQuadTo(480f, 160f)
                quadToRelative(62f, 0f, 119f, 20f)
                reflectiveQuadToRelative(107f, 58f)
                lineToRelative(56f, -56f)
                lineToRelative(56f, 56f)
                lineToRelative(-56f, 56f)
                quadToRelative(38f, 50f, 58f, 107f)
                reflectiveQuadToRelative(20f, 119f)
                quadToRelative(0f, 74f, -28.5f, 139.5f)
                reflectiveQuadTo(734f, 774f)
                reflectiveQuadToRelative(-114.5f, 77.5f)
                reflectiveQuadTo(480f, 880f)
                moveToRelative(0f, -80f)
                quadToRelative(116f, 0f, 198f, -82f)
                reflectiveQuadToRelative(82f, -198f)
                reflectiveQuadToRelative(-82f, -198f)
                reflectiveQuadToRelative(-198f, -82f)
                reflectiveQuadToRelative(-198f, 82f)
                reflectiveQuadToRelative(-82f, 198f)
                reflectiveQuadToRelative(82f, 198f)
                reflectiveQuadToRelative(198f, 82f)
                moveToRelative(0f, -280f)
            }
        }.build()
        return _Timer!!
    }

private var _Timer: ImageVector? = null

public val Dinner_dining: ImageVector
    get() {
        if (_Dinner_dining != null) {
            return _Dinner_dining!!
        }
        _Dinner_dining = ImageVector.Builder(
            name = "Dinner_dining",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(160f, 840f)
                lineToRelative(-80f, -80f)
                horizontalLineToRelative(800f)
                lineToRelative(-80f, 80f)
                close()
                moveToRelative(-40f, -120f)
                quadToRelative(6f, -18f, 16f, -34f)
                reflectiveQuadToRelative(24f, -30f)
                verticalLineToRelative(-296f)
                horizontalLineToRelative(-40f)
                verticalLineToRelative(-60f)
                horizontalLineToRelative(40f)
                verticalLineToRelative(-30f)
                horizontalLineToRelative(-40f)
                verticalLineToRelative(-60f)
                horizontalLineToRelative(40f)
                verticalLineToRelative(-30f)
                horizontalLineToRelative(-40f)
                verticalLineToRelative(-60f)
                horizontalLineToRelative(280f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(480f, 200f)
                verticalLineToRelative(10f)
                horizontalLineToRelative(360f)
                verticalLineToRelative(60f)
                horizontalLineTo(480f)
                verticalLineToRelative(10f)
                quadToRelative(0f, 33f, -23.5f, 56.5f)
                reflectiveQuadTo(400f, 360f)
                horizontalLineToRelative(-80f)
                verticalLineToRelative(244f)
                quadToRelative(14f, 2f, 28f, 6f)
                reflectiveQuadToRelative(26f, 12f)
                quadToRelative(26f, -65f, 83f, -103.5f)
                reflectiveQuadTo(583f, 480f)
                quadToRelative(90f, 0f, 153.5f, 61.5f)
                reflectiveQuadTo(800f, 692f)
                verticalLineToRelative(28f)
                close()
                moveToRelative(334f, -80f)
                horizontalLineToRelative(252f)
                quadToRelative(-17f, -36f, -50f, -58f)
                reflectiveQuadToRelative(-73f, -22f)
                quadToRelative(-42f, 0f, -77f, 21f)
                reflectiveQuadToRelative(-52f, 59f)
                moveTo(320f, 210f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(-30f)
                horizontalLineToRelative(-80f)
                close()
                moveToRelative(0f, 90f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(-30f)
                horizontalLineToRelative(-80f)
                close()
                moveToRelative(-100f, -90f)
                horizontalLineToRelative(40f)
                verticalLineToRelative(-30f)
                horizontalLineToRelative(-40f)
                close()
                moveToRelative(0f, 90f)
                horizontalLineToRelative(40f)
                verticalLineToRelative(-30f)
                horizontalLineToRelative(-40f)
                close()
                moveToRelative(0f, 314f)
                quadToRelative(10f, -5f, 19.5f, -7.5f)
                reflectiveQuadTo(260f, 602f)
                verticalLineToRelative(-242f)
                horizontalLineToRelative(-40f)
                close()
                moveToRelative(360f, 26f)
            }
        }.build()
        return _Dinner_dining!!
    }

private var _Dinner_dining: ImageVector? = null


public val Logout: ImageVector
    get() {
        if (_Logout != null) {
            return _Logout!!
        }
        _Logout = ImageVector.Builder(
            name = "Logout",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(200f, 840f)
                quadToRelative(-33f, 0f, -56.5f, -23.5f)
                reflectiveQuadTo(120f, 760f)
                verticalLineToRelative(-560f)
                quadToRelative(0f, -33f, 23.5f, -56.5f)
                reflectiveQuadTo(200f, 120f)
                horizontalLineToRelative(280f)
                verticalLineToRelative(80f)
                horizontalLineTo(200f)
                verticalLineToRelative(560f)
                horizontalLineToRelative(280f)
                verticalLineToRelative(80f)
                close()
                moveToRelative(440f, -160f)
                lineToRelative(-55f, -58f)
                lineToRelative(102f, -102f)
                horizontalLineTo(360f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(327f)
                lineTo(585f, 338f)
                lineToRelative(55f, -58f)
                lineToRelative(200f, 200f)
                close()
            }
        }.build()
        return _Logout!!
    }

private var _Logout: ImageVector? = null




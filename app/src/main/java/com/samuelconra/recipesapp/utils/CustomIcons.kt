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
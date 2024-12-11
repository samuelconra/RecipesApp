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

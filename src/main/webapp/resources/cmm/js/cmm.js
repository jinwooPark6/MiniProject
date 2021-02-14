'use strict'
var cmm = cmm || {}
cmm = (() => {
	const init = x => {
		$('#write').click(e => {location.href=`${x}/move/brd/write`})
		$('#list').click(e => {location.href=`${x}/move/brd/list`})
		$('#detail').click(e => {location.href=`${x}/move/brd/detail`})
	}
	const goHome = x => {location.href = `${x}/`}
	return {init, goHome}
})()
'use strict'
var cmm = cmm || {}
cmm = (() => {
	const init = x => { // add 페이지로 이동하는 거
        $('#add').click(e => {location.href=`${x}/move/shw/add`})
        $('#list').click(e => {location.href=`${x}/move/shw/list`})
		
	}
	
	/*const goHome = x => {
		$(`#goHome`).click(e => {location.href=`${x}/`})
	}*/
	const goHome = x => {location.href = `${x}/`}
	return {init, goHome}
})()

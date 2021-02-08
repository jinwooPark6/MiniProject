'use strict'
var cmm = cmm || {}
cmm = (() => {
	const init = x => {
        $('#list').click(e => {location.href=`${x}/move/bkg/list`})
        $('#booking').click(e => {location.href=`${x}/move/bkg/booking`})
		$('#insert-many-bkg').click(e => {
			e.preventDefault()
			$.getJSON(`${x}/bookings/insert-many/${$('#bkg-count').val()}`, d => {
				alert(`${$('#bkg-count').val()}건 더미데이터 생성`)
				location.reload()
			})
		})
	}
	const goHome = x => {location.href = `${x}/`}
	return { init, goHome }
})()

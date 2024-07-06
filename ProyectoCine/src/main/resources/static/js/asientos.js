function cambiarColor(button) {
	var asientoText = button.textContent.trim();
	var asientosSeleccionados = document.getElementById('selected-seats');

	if (button.classList.contains('bg-warning')) {
		// Botón amarillo: add selected seat
		var textNode = document.createTextNode(asientoText + ' ');
		asientosSeleccionados.appendChild(textNode);
	} else if (button.classList.contains('bg-danger')) {
		// Botón rojo: remove selected seat
		var seatNodes = asientosSeleccionados.childNodes;
		for (var i = 0; i < seatNodes.length; i++) {
			if (seatNodes[i].textContent.trim() === asientoText) {
				asientosSeleccionados.removeChild(seatNodes[i]);
				break;
			}
		}
	}

	// Toggle cambiar el color del botón
	button.classList.toggle('bg-warning');
	button.classList.toggle('bg-danger');
}

function confirmarBoletaPdf() {
	// Obtienes los asientos seleccionados
	var asientosSeleccionados = document.getElementById('selected-seats');
	var arrAsientos = [];
	for (var i = 0; i < asientosSeleccionados.childNodes.length; i++) {
		arrAsientos.push(asientosSeleccionados.childNodes[i].textContent.trim());
	}

	// Update hidden input with selected seats
	var asientosInput = document.getElementById('asientos-seleccionados-pdf');
	asientosInput.value = arrAsientos.join(', ');

	// Envia el formulario PDF
	var confirmationPdfForm = document.getElementById('confirmation-pdf-form');
	confirmationPdfForm.submit();
}
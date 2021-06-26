// Поля не возвращаются в исходное состояние (я про label)

function clearCreateFundModal() {
  let fundNumber = document.getElementById('fundNumberCreate');
  let fundLetter = document.getElementById('fundLetterCreate');
  let fundName = document.getElementById('fundNameCreate');
  let newFundDate = document.getElementById('date');

  fundNumber.value = "";
  fundLetter.value = "";
  fundName.value = "";
  newFundDate.value = "";
}

export default clearCreateFundModal;
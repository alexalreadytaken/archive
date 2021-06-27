function search(){
  let inputFundNumber = document.getElementById('fundNumber');
  let inputFundName = document.getElementById('fundName');

  fetch('http://10.3.0.87:3000/fund')
  .then(res => res.json())
  .then(json => console.log(json))
  .catch(console.error('Что то не так...'));
}


export default search;



import './App.css';
import React,{useState} from 'react';
import Header from './header/header.jsx';
import Search from './search/search.jsx';
import searchFund from './search/searchFund.js'
import MainContent from './main-content/main-content.jsx';
import InventoryTable from './main-content/main-components/main-inventory-table/main-inventory-table.jsx';
import TablesForAffairs from './main-content/main-components/tables-for-affairs/tables-for-affairs.jsx';
import AffairTitle from './main-content/main-components/tables-for-affairs/block-affait-title/block-affait-title.jsx';
import ButtonsAffair from './main-content/main-components/tables-for-affairs/block-buttons-affair/block-buttons-affair.jsx';
import BtnOtherTables from './main-content/main-components/tables-for-affairs/buttons-other-tables/buttons-other-tables.jsx';
import PointerTable from './main-content/main-components/tables-for-affairs/pointer-table/pointer-table.jsx';
import StatesTable from './main-content/main-components/tables-for-affairs/states-table/states-table.jsx';
import AffairsTable from './main-content/main-components/tables-for-affairs/affairs-table/main-affairs-table.jsx';
import Modal from './modal/modal.jsx';
import CreateFound from './modal/modal-content/create-found.jsx'
import createFound from './modal/functions/createFound.js';
import OldNameElement from './modal/modal-content/modal-oldName-elem';

import SockJsClient from 'react-stomp';

const SOCKET_URL = 'http://10.3.0.87:3000/archive-ws';

function App(props) {

  const [message, setMessage] = useState('You server message here.');

  let onConnected = () => {
    console.log("Connected!!")
    setTimeout(sendMessage,1000)
  }

  let onMessageReceived = (msg) => {
    setMessage(msg.message);
  }

  let sendMessage = () => {
        fetch("http://10.3.0.87:3000/some/string",{method:'POST',body:JSON.stringify({s:"hello"})})
    };

  // Модальное окно
  const [modalCreatelActive, setCreateModalActive] = useState(false);
  const [modalEditingActive, setEditingModalActive] = useState(false);
  
  // Показ таблицы указатилей
  let [visible, setVisible] = useState('none');
  const visibleChange = ( ) =>{
    let affairsTable = document.getElementById('affairs-table');
    let pointerTable = document.getElementById('pointer-table');
    if(visible === 'none'){
      setVisible('block');
      affairsTable.style.height = '250px'
      pointerTable.style.height = '200px'
    }else{
      setVisible('none');
      affairsTable.style.height = '450px'
    }
  }

  return (
    <>
    {/* <SockJsClient
        url={SOCKET_URL}
        topics={['/topic/strings']}
        onConnect={onConnected}
        onDisconnect={console.log("Disconnected!")}
        onMessage={msg => console.log(msg)}
        debug={false}

        
        // ref={(client) => {this.clientRef = client}}
      /> */}

      <Header/>
        <div className="container">
          <Search setActive2={setEditingModalActive} setActive={setCreateModalActive} />
          <MainContent>              
            <InventoryTable/>
            <TablesForAffairs>
              <AffairsTable id='affairs-table' height='450px'/>
              <AffairTitle title='Заголовок'/>
              <ButtonsAffair/>
              <PointerTable id='pointer-table' height='200px' visible={visible}/>
              {/* <StatesTable/> */}
              <BtnOtherTables visibleCh={visibleChange}/>
            </TablesForAffairs>
          </MainContent>
        </div>
        <Modal createFound={createFound} active={modalCreatelActive} setActive={setCreateModalActive}>
          <CreateFound setActive={setCreateModalActive}><OldNameElement/></CreateFound>
        </Modal>

        <Modal  active={modalEditingActive} setActive={setEditingModalActive}>
        </Modal>
    </>
  );
}

export default App;

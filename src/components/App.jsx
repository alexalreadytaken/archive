import './App.css';
import React,{useState} from 'react';
import Header from './header/header.jsx';
import Search from './search/search.jsx';
import MainContent from './main-content/main-content.jsx';
import InventoryTable from './main-content/main-components/main-inventory-table/main-inventory-table.jsx';
import TablesForAffairs from './main-content/main-components/tables-for-affairs/tables-for-affairs.jsx';
import AffairTitle from './main-content/main-components/tables-for-affairs/block-affait-title/block-affait-title.jsx';
import ButtonsAffair from './main-content/main-components/tables-for-affairs/block-buttons-affair/block-buttons-affair.jsx';
import BtnOtherTables from './main-content/main-components/tables-for-affairs/buttons-other-tables/buttons-other-tables.jsx';
import PointerTable from './main-content/main-components/tables-for-affairs/pointer-table/pointer-table.jsx';
import StatesTable from './main-content/main-components/tables-for-affairs/states-table/states-table.jsx';
import AffairsTable from './main-content/main-components/tables-for-affairs/affairs-table/main-affairs-table.jsx';


function App() {

  
  let [visible, setVisible] = useState('none');

  const visibleChange = ( ) =>{
    if(visible === 'none'){
      setVisible('block');
    }else{
      setVisible('none');
    }
  }

  return (
    // Этот див обертка для того чтобы реакт понимал так как все теги должны быть внутри одного главного
    <div>
      <Header/>
        <div className="container">
          <Search/>
          <MainContent>              
            <InventoryTable/>
            <TablesForAffairs>
              <AffairsTable/>
              <AffairTitle title='Заголовок;'/>
              <ButtonsAffair/>
              <PointerTable visible={visible}/>
              {/* <StatesTable/> */}
              <BtnOtherTables visibleCh={visibleChange}/> 
            </TablesForAffairs>
          </MainContent>
        </div>
    </div>
  );
}

export default App;

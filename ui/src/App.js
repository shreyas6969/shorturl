import logo from './logo.svg';
import './App.css';
import { Layout } from 'antd';
import MyHeader from './Header/MyHeader'
import MyFooter from './Footer/MyFooter'
import Home from './Home/Home'

const { Header, Footer, Sider, Content } = Layout;

function App() {
  return (
    <div className="App">
     <Layout>
      <Header>
        <MyHeader/>
        </Header>
      <Content>
        <Home/>
        </Content>
      <Footer>
        <MyFooter/>
        </Footer>
    </Layout>
    </div>
  );
}

export default App;

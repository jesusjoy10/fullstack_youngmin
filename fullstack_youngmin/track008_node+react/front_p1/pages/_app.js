import React from 'react';
import PropTypes from 'prop-types';
import Head from 'next/head';
import 'antd/dist/antd.css'; // 👈 이 코드가 반드시 있어야 합니다!
import { wrapper } from '../store/configureStore';

const App = ({ Component, pageProps }) => {
  return (
    <>
      <Head>
        <meta charSet="utf-8" />
        <title>오늘 뭐 먹지?</title>
      </Head>
      <Component {...pageProps} />
    </>
  );
};

App.propTypes = {
  Component: PropTypes.elementType.isRequired,
  pageProps: PropTypes.object.isRequired,
};

export default wrapper.withRedux(App);